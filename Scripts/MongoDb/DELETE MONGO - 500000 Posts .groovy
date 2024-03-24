import com.mongodb.client.MongoCollection
import org.bson.Document
import com.mongodb.client.model.Filters

MongoCollection<Document> collection = vars.getObject("postsCollection");

def filter = Filters.lt("id", 0);

// Perform delete operation
def deleteResult = collection.deleteMany(filter);
