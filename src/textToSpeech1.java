/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Aadithya Varma
 */
import javax.speech.*;    
import java.util.*;    
import javax.speech.synthesis.*;    

public class textToSpeech1    
{    
String speaktext; 
public void dospeak(String speak,String  voicename)    
{    
    speaktext=speak;    
    String voiceName =voicename;    
    try    
    {    
        SynthesizerModeDesc desc = new SynthesizerModeDesc(null,"general",  Locale.US,null,null);    
        Synthesizer synthesizer =  Central.createSynthesizer(desc);    
        synthesizer.allocate();    
        synthesizer.resume();     
        desc = (SynthesizerModeDesc)  synthesizer.getEngineModeDesc();     
        Voice[] voices = desc.getVoices();      
        Voice voice = null;
        for (int i = 0; i < voices.length; i++)    
        {    
            if (voices[i].getName().equals(voiceName))    
            {    
                voice = voices[i];    
                break;     
            }     
        }    
        synthesizer.getSynthesizerProperties().setVoice(voice);    
        System.out.print("Speaking : "+speaktext);    
        synthesizer.speakPlainText(speaktext, null);    
        synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);    
        synthesizer.deallocate();    
    }    
    catch (Exception e)   
    {    
        String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";    
        System.out.println(""+e);    
        System.out.println(message);    
    }    
}    

public static void main(String[] args)    
{    
  textToSpeech obj=new textToSpeech(); obj.dospeak("Mike testing","kevin16");
  System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

}    
}
