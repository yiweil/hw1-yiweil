package annotator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import datatype.*;


/**
 * 
 * gkeopjfepjwfeop
 * @author kane
 *
 */
public class GeneSelector extends JCasAnnotator_ImplBase {
  private BufferedReader geneDataReader;
  private ArrayList<String> geneList;
  
  @Override
  public void initialize(UimaContext aContext)
          throws ResourceInitializationException{
    URL url=getClass().getResource("/home/kane/workspace/hw1-yiweil/src/main/resources/genenames.txt");
    File geneData=new File("/home/kane/workspace/hw1-yiweil/src/main/resources/genenames.txt");
    geneList=new ArrayList<String>();
    try {
      geneDataReader=new BufferedReader(new FileReader(geneData));
      String geneName;
      while((geneName=geneDataReader.readLine())!=null){
        geneList.add(geneName.trim().toUpperCase());
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    FSIndex nounIndex=aJCas.getAnnotationIndex(Noun.type);
    Iterator nounIterator=nounIndex.iterator();
    String context=aJCas.getDocumentText();
    while(nounIterator.hasNext()){
      Noun nounAnnotation=(Noun)nounIterator.next();
      String token=context.substring(nounAnnotation.getBegin(),nounAnnotation.getEnd());
      if(geneList.contains(token.trim().toUpperCase())){
        Gene geneAnnotation=new Gene(aJCas);
        geneAnnotation.setBegin(nounAnnotation.getBegin());
        geneAnnotation.setEnd(nounAnnotation.getEnd());
        geneAnnotation.setId(nounAnnotation.getId());
        geneAnnotation.setSentenceStart(nounAnnotation.getSentenceStart());
        geneAnnotation.addToIndexes();
      }
    }
    
  }

}
