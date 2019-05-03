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
		//Conecto-me a coleção desejada
		MongoCollection<Document> collection = database.getCollection("alunos");
		
		Document first = collection.find().first();
		System.out.println(first);
		//Criação de um novo documento
		/*Document document = new Document("nome", "Pedro")
							.append("data_nascimento", new Date(04, 11, 1998))
							.append("curso", new Document("nome", "Ciências da Computação"))
							.append("habilidades", Arrays.asList(new Document("nome", "Windows Server").append("nível", "Intermediário")))
							.append("notas", Arrays.asList(9, 7, 8))
							.append("contato", 
									new Document("endereco", "R. São Roberto, 2-140 - Estácio, Rio de Janeiro, Brazil")
									.append("cordinates", Arrays.asList(-22.917518, -43.205313))
									.append("type", "Point"));*/
		
		/*Document document = new Document("nome", "João").append("data_nascimento", new Date(2003,10,10))
				.append("curso", new Document("nome", "História"))
				.append("notas", Arrays.asList(10, 9, 8))
				.append("habilidades", Arrays.asList(new Document("nome", "Inglês")
													.append("nível", "Básico"),
													 new Document()
													 .append("nome", "Espanhol")
													 .append("nível", "Básico")));*/
		
		//collection.insertOne(document);
		
		//Atualização
		//collection.updateOne(Filters.eq("nome", "João"), new Document("$set", new Document("nome", "João Silva")));
		
		collection.deleteOne(Filters.eq("nome", "João"));
		//Fecha a conexão
		cliente.close();
	}
}