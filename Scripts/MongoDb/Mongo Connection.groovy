import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress; // Import ServerAddress class
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters

// MongoDB connection parameters

String host = "localhost";
int port = 27017;
String dbName = "StackOverflow2010";
String collectionName = "posts";
String username = "admin";
String password = "*****";
int batchSize = 1000; // Adjust batch size as needed

// Create MongoCredential object
MongoCredential credential = MongoCredential.createCredential(username, dbName, password.toCharArray());

// Establish connection to MongoDB with credential
MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), Collections.singletonList(credential));
MongoDatabase database = mongoClient.getDatabase(dbName);
MongoCollection<Document> collection = database.getCollection(collectionName);

vars.putObject("postsCollection", collection);

def filter = Filters.lt("id", 0);
// Perform delete operation
def deleteResult = collection.deleteMany(filter);

return "Connected";