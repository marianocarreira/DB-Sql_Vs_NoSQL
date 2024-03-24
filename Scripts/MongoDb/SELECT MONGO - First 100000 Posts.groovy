import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

MongoCollection<Document> collection = vars.getObject("postsCollection");

// Query all documents from the collection using batching
MongoIterable<Document> result = collection.find().limit(100000);

// Initialize list to store JSON strings representing documents
List<String> resultList = new ArrayList<>();

// Iterate over the cursor to retrieve documents in batches
MongoCursor<Document> cursor = result.iterator();
while (cursor.hasNext()) {
    Document document = cursor.next();
    resultList.add(document.toJson());
}

return resultList;