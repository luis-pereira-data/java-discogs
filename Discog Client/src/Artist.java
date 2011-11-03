import java.io.IOException;
import java.util.Collection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Artist {
  
  public static Artist getArtist(String name, boolean releases) throws ClientProtocolException, IOException {
    
    HttpClient client = new DefaultHttpClient();
    HttpGet request =  new HttpGet("http://api.discogs.com/artist/" + name);
    request.addHeader("Accept-Encoding" , "gzip");
    HttpResponse response = client.execute(request);
    HttpEntity entity = response.getEntity();
    String jsonObject = EntityUtils.toString(entity); 
    System.out.println(jsonObject);
    
    Gson gson = new GsonBuilder().create();
    gson.fromJson(jsonObject, Artist.class);
   
    Root root = gson.fromJson(jsonObject, Root.class);
    
    return root.getResp().getArtist();
    
  }
  
  
  
  private String name;
  
  private Collection<String> namevariations; 
  
  private Collection<String> urls;
  
  private Collection<Images> images;
  
  private String realname;
  
  private Collection<String> aliases;
  
  private String profile;
  
  private Collection<String> members;
  
  private long id;
  
  private String data_quality;
  
  private String resource_url;
  
  private Collection<Release> release;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<String> getNamevariations() {
    return namevariations;
  }

  public void setNamevariations(Collection<String> namevariations) {
    this.namevariations = namevariations;
  }

  public Collection<String> getUrls() {
    return urls;
  }

  public void setUrls(Collection<String> urls) {
    this.urls = urls;
  }

  public Collection<Images> getImages() {
    return images;
  }

  public void setImages(Collection<Images> images) {
    this.images = images;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public Collection<String> getAliases() {
    return aliases;
  }

  public void setAliases(Collection<String> aliases) {
    this.aliases = aliases;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public Collection<String> getMembers() {
    return members;
  }

  public void setMembers(Collection<String> members) {
    this.members = members;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getData_quality() {
    return data_quality;
  }

  public void setData_quality(String data_quality) {
    this.data_quality = data_quality;
  }

  public String getResource_url() {
    return resource_url;
  }

  public void setResource_url(String resource_url) {
    this.resource_url = resource_url;
  }

  public Collection<Release> getRelease() {
    return release;
  }

  public void setRelease(Collection<Release> release) {
    this.release = release;
  } 
  
}
