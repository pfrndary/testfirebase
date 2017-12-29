package firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class Launcher {


    public static void main(String... a) throws IOException, InterruptedException, ExecutionException {
        final InputStream serviceAccount = ClassLoader.getSystemResourceAsStream("private-client-firebase.json");

        final FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://divine-surface-189602.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
        //ApiFuture<String> customTokenAsync = FirebaseAuth.getInstance().createCustomTokenAsync("8Ube0DWXPjc4DYMkR5aa0aQtDQ83");
        //String s = customTokenAsync.get();
        //System.out.println(s);
        final FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance();
        defaultDatabase.getReference().child("test").setValue("newValue2", new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                System.out.println(databaseReference);
            }
        });
        Thread.sleep(99999);
    }

}
