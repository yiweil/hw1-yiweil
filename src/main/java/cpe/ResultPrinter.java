package cpe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.collection.base_cpm.CasObjectProcessor;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

import datatype.*;

/**
 * The ResultPrinter is the Cas Consumer that takes the output from the analysis machine
 * It will record the result in a file called hw1-yiweil.out file in the required format
 * @author kane
 *
 */
public class ResultPrinter extends CasConsumer_ImplBase implements CasObjectProcessor {
  File resultFile;

  FileWriter fileWriter;

  public ResultPrinter() {
  }

  /**
   * Initializes this CAS Consumer with the parameters specified in the descriptor.
   * 
   * @throws ResourceInitializationException
   *           if there is error in initializing the resources
   */
  public void initialize() throws ResourceInitializationException {

    // extract configuration parameter settings
    resultFile=new File("hw1-yiweil.out");

    try {
      fileWriter = new FileWriter(resultFile);
    } catch (IOException e) {
      throw new ResourceInitializationException(e);
    }
  }

  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS index is iterated over selected annotations and printed out into an
   * output file
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(CAS)
   */
  public synchronized void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    String context=jcas.getDocumentText();
    Iterator geneIterator = jcas.getAnnotationIndex(Gene.type).iterator();
    while (geneIterator.hasNext()) {
      System.out.println("+1");
      Gene geneAnnotation = (Gene)geneIterator.next();
      try{
        fileWriter.write(geneAnnotation.getId()+"|"
                +(geneAnnotation.getBegin()-geneAnnotation.getSentenceStart())
                +" "+(geneAnnotation.getEnd()-geneAnnotation.getSentenceStart())+"|"
                +" "+context.substring(geneAnnotation.getBegin(), geneAnnotation.getEnd())+"\n");
        fileWriter.flush();
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      }
    }
  }

 
  public void batchProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    // nothing to do in this case as AnnotationPrinter doesnot do
    // anything cumulatively
  }

  
  public void collectionProcessComplete(ProcessTrace aTrace) throws ResourceProcessException,
          IOException {
    if (fileWriter != null) {
      fileWriter.close();
    }
  }

  
  public void destroy() {
    if (fileWriter != null) {
      try {
        fileWriter.close();
      } catch (IOException e) {
        // ignore IOException on destroy
      }
    }
  }

}
