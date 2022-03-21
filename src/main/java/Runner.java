import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Runner {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        System.out.println("Hello World");
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        final String projectId = "fleet-geode-336620";
        final String topicId = "hello_topic";

        String resourceName = "projects/"+projectId+"/topics/"+topicId;

        Publisher publisher = Publisher.newBuilder(resourceName)
                .build();

        String res = publisher
                .publish(PubsubMessage
                        .newBuilder()
                        .setData(ByteString.copyFromUtf8("Hello World"))
                        .build())
                .get(); // Future.get, returns the messageId as String, like 4240701874214185

        System.out.println(res);

    }
}
