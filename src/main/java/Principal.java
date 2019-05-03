import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

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
		//Cria��o de um novo documento
		/*Document document = new Document("nome", "Pedro")
							.append("data_nascimento", new Date(04, 11, 1998))
							.append("curso", new Document("nome", "Ci�ncias da Computa��o"))
							.append("habilidades", Arrays.asList(new Document("nome", "Windows Server").append("n�vel", "Intermedi�rio")))
							.append("notas", Arrays.asList(9, 7, 8))
							.append("contato", 
									new Document("endereco", "R. S�o Roberto, 2-140 - Est�cio, Rio de Janeiro, Brazil")
									.append("cordinates", Arrays.asList(-22.917518, -43.205313))
									.append("type", "Point"));*/
		
		/*Document document = new Document("nome", "Jo�o").append("data_nascimento", new Date(2003,10,10))
				.append("curso", new Document("nome", "Hist�ria"))
				.append("notas", Arrays.asList(10, 9, 8))
				.append("habilidades", Arrays.asList(new Document("nome", "Ingl�s")
													.append("n�vel", "B�sico"),
													 new Document()
													 .append("nome", "Espanhol")
													 .append("n�vel", "B�sico")));*/
		
		//collection.insertOne(document);
		
		//Atualiza��o
		//collection.updateOne(Filters.eq("nome", "Jo�o"), new Document("$set", new Document("nome", "Jo�o Silva")));
		
		collection.deleteOne(Filters.eq("nome", "Jo�o"));
		//Fecha a conex�o
		cliente.close();
	}
}