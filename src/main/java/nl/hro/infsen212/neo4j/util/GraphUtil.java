package nl.hro.infsen212.neo4j.util;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.Index;

public class GraphUtil {
	@SuppressWarnings("deprecation")
	public static void cleanUp(final GraphDatabaseService graphDb,
			final Index<Node> nodeIndex) {
		for (Node node : graphDb.getAllNodes()) {
			for (Relationship rel : node.getRelationships()) {
				rel.delete();
			}
			nodeIndex.remove(node);
			node.delete();
		}

	}

	public static void registerShutdownHook(final GraphDatabaseService graphDb) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				graphDb.shutdown();
			}
		});
	}

	 

}
