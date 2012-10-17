import java.util.Iterator;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;


public class NounDetector extends JCasAnnotator_ImplBase {
  private PosTagNamedEntityRecognizer nounRecognizer;
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    FSIndex sentenceIndex=aJCas.getAnnotationIndex(Sentence.type);
    Iterator sentenceIterator=sentenceIndex.iterator();
    String context=aJCas.getDocumentText();
    try {
      nounRecognizer=new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    while (sentenceIterator.hasNext()){
      Sentence sentence=(Sentence)sentenceIterator.next();
      Map<Integer,Integer> map =nounRecognizer.getGeneSpans(context.substring(sentence.getBegin(), sentence.getEnd()));
      Iterator beginIterator=map.keySet().iterator();
      while(beginIterator.hasNext()){
        Integer begin=(Integer)beginIterator.next();
        Integer end=map.get(begin);
        Noun nounAnnotation=new Noun(aJCas);
        nounAnnotation.setBegin(sentence.getBegin()+begin);
        nounAnnotation.setEnd(sentence.getBegin()+end);
        nounAnnotation.setId(sentence.getId());
        nounAnnotation.setSentenceStart(sentence.getBegin());
        nounAnnotation.addToIndexes();
      }
    }
  }

}
