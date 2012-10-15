import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;


public class GeneSelector extends JCasAnnotator_ImplBase {
  private BufferedReader geneDataReader;

  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    URL url=getClass().getResource("genenames.txt");
    File geneData=new File(url.getPath());
    try {
      geneDataReader=new BufferedReader(new FileReader(geneData));
      String geneName;
      while((geneName=geneDataReader.readLine())!=null){
        System.out.println(geneName);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
