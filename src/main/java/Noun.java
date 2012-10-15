

/* First created by JCasGen Sun Oct 14 03:02:31 EDT 2012 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Oct 14 21:49:22 EDT 2012
 * XML source: /home/kane/workspace/hw1-yiweil/src/main/resources/type_system_descriptor.xml
 * @generated */
public class Noun extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Noun.class);
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
  protected Noun() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Noun(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Noun(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Noun(JCas jcas, int begin, int end) {
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
    if (Noun_Type.featOkTst && ((Noun_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "Noun");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Noun_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Noun_Type.featOkTst && ((Noun_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "Noun");
    jcasType.ll_cas.ll_setStringValue(addr, ((Noun_Type)jcasType).casFeatCode_id, v);}    
  }

    