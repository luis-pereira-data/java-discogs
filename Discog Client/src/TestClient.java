import java.io.IOException;

import org.apache.http.client.ClientProtocolException;


public class TestClient {
  
  
  public static void main(String[] args) throws ClientProtocolException, IOException{
    
   System.out.println(Artist.getArtist("Foo+Fighters", false).getName());
    
  }

}
