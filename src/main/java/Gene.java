

/* First created by JCasGen Sun Oct 14 21:49:22 EDT 2012 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Oct 17 11:59:06 EDT 2012
 * XML source: /home/kane/workspace/hw1-yiweil/src/main/resources/type_system_descriptor.xml
 * @generated */
public class Gene extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Gene.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Gene() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Gene(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Gene(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Gene(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "Gene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Gene_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "Gene");
    jcasType.ll_cas.ll_setStringValue(addr, ((Gene_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: sentenceStart

  /** getter for sentenceStart - gets Start index of the sentence that this gene annotation belongs to
   * @generated */
  public int getSentenceStart() {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_sentenceStart == null)
      jcasType.jcas.throwFeatMissing("sentenceStart", "Gene");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Gene_Type)jcasType).casFeatCode_sentenceStart);}
    
  /** setter for sentenceStart - sets Start index of the sentence that this gene annotation belongs to 
   * @generated */
  public void setSentenceStart(int v) {
    if (Gene_Type.featOkTst && ((Gene_Type)jcasType).casFeat_sentenceStart == null)
      jcasType.jcas.throwFeatMissing("sentenceStart", "Gene");
    jcasType.ll_cas.ll_setIntValue(addr, ((Gene_Type)jcasType).casFeatCode_sentenceStart, v);}    
  }

    