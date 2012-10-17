package cpe;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */



import java.io.File;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;


/**
 * The InputFileReader class is the collection reader that reads the input file of
 * hw1.in and construct the JCas object which will be used by the annotator
 * 
 * @author kane
 *
 */
public class InputFileReader extends CollectionReader_ImplBase {
  
  public static final String PARAM_INPUTDIR = "InputDirectory";

  private File inputFile;  
  
  private boolean read;

  
  public void initialize() throws ResourceInitializationException {
  
    inputFile=new File(((String)getConfigParameterValue(PARAM_INPUTDIR)).trim()+"/hw1.in");
    read=false;
  }
  



  public boolean hasNext() {
    return !read;
  }


  public void getNext(CAS aCAS) throws IOException, CollectionException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }

    // open input stream to file
    String context = FileUtils.file2String(inputFile);
      // put document in CAS
    jcas.setDocumentText(context);
    read=true;

  }


  public void close() throws IOException {
  }


  public Progress[] getProgress() {
    return new Progress[] { new ProgressImpl(read?1:0, 1, Progress.ENTITIES) };
  }

  public int getNumberOfDocuments() {
    return 1;
  }

}
