import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Principal {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Crio o cliente
		MongoClient cliente = MongoClients.create();
		//Conecto-me ao bd
		MongoDatabase database = cliente.getDatabase("test");
		//Conecto-me a cole��o desejada
		MongoCollection<Document> collection = database.getCollection("alunos");
		
		Document first = collection.find().first();
		System.out.println(first);
		
		Document document = new Document("nome", "Jo�o").append("data_nascimento", new Date(2003,10,10))
									.append("curso", new Document("nome", "Hist�ria"))
									.append("notas", Arrays.asList(10, 9, 8))
									.append("habilidades", Arrays.asList(new Document()
																		.append("nome", "Ingl�s")
																		.append("n�vel", "B�sico"),
																		 new Document()
																		 .append("nome", "Espanhol")
																		 .append("n�vel", "B�sico")));
		collection.insertOne(document);
		//Fecha a conex�o
		cliente.close();
	}
}