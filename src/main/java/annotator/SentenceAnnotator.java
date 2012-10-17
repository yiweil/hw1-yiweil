package annotator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.tutorial.RoomNumber;
import datatype.*;

/**
 * Example annotator that detects room numbers using Java 1.4 regular expressions.
 */
public class SentenceAnnotator extends JCasAnnotator_ImplBase {
  /**
   * @see JCasAnnotator_ImplBase#process(JCas)
   */
  private PosTagNamedEntityRecognizer nounRecognizer;
  
  public void process(JCas aJCas) {
    // get document text
    try{
      nounRecognizer=new PosTagNamedEntityRecognizer();
    }catch(ResourceInitializationException e){
      e.printStackTrace();
    }
    String docText = aJCas.getDocumentText();
    String eol=System.getProperty("line.separator");
    String[] sentence=docText.split(eol);
    int i=0;
    for(int j=0;j<sentence.length;j++){
      String key="";
      if(j<10)
      System.out.println(sentence[j]);
      String[] tokens=sentence[j].split(" ");
      key=tokens[0];
      Sentence annotation=new Sentence(aJCas);
      annotation.setBegin(i+tokens[0].length()+1);
      annotation.setEnd(i+sentence[j].length());
      annotation.setId(key);
      i=i+sentence[j].length()+1;
      annotation.addToIndexes();
    }
    // search for Yorktown room numbers
    /*
    Matcher matcher = mYorktownPattern.matcher(docText);
    while (matcher.find()) {
      // found one - create annotation
      RoomNumber annotation = new RoomNumber(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.setBuilding("Yorktown");
      annotation.addToIndexes();
    }
    // search for Hawthorne room numbers
    matcher = mHawthornePattern.matcher(docText);
    while (matcher.find()) {
      // found one - create annotation
      RoomNumber annotation = new RoomNumber(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.setBuilding("Hawthorne");
      annotation.addToIndexes();
    }
    */
  }

}