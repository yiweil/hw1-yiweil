package annotator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import datatype.*;


 /**
  * The sentence annotator is the first annotator in the analysis machine that truncate the
  * original context to separated strings by the line separators.
  * The output is the annotation called Sentence and will be the input to the next stage of NounDetector
  * 
 * @author kane
 *
 */
public class SentenceAnnotator extends JCasAnnotator_ImplBase {

  
  public void process(JCas aJCas) {
    // get document text
    String docText = aJCas.getDocumentText();
    String eol=System.getProperty("line.separator");
    String[] sentence=docText.split(eol);
    int i=0;
    for(int j=0;j<sentence.length;j++){
      String key="";
      String[] tokens=sentence[j].split(" ");
      key=tokens[0];
      Sentence annotation=new Sentence(aJCas);
      annotation.setBegin(i+tokens[0].length()+1);
      annotation.setEnd(i+sentence[j].length());
      annotation.setId(key);
      i=i+sentence[j].length()+1;
      annotation.addToIndexes();
    }
  }

}