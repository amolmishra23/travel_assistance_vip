import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.sun.speech.freetts.Voice; 
import com.sun.speech.freetts.VoiceManager; 

public class Demofreetts {
 // Default voice is Kevin16
 private static final String VOICENAME = "kevin16";

 public static void main(String[] args) {
  Voice voice;
  // Taking instance of voice from VoiceManager factory.
  VoiceManager voiceManager = VoiceManager.getInstance();
  voice = voiceManager.getVoice(VOICENAME);
  // Allocating voice
  voice.allocate();
  // word per minute
  voice.setRate(120);
  voice.setPitch(100);
  System.out.print("Enter your text: ");
  // open up standard input
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  try {
   // Ready to speak
   voice.speak(br.readLine());
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
}