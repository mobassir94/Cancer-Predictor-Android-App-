package com.example.cancerpredictor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.SparseInstance;

import static weka.core.SerializationHelper.read;

public class cervicalcancer extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5,et6,et7;
    Button predict;

    private RadioButton radioButton;
    private RadioGroup radiogroup,radiogroup1,radiogroup2,radiogroup3,radiogroup4,radiogroup5,radiogroup6,radiogroup7,radiogroup8, radiogroup9,radiogroup10,radiogroup11,radiogroup12,radiogroup13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cervical);

        et1 = (EditText)findViewById(R.id.age);
        et2 = (EditText)findViewById(R.id.sexpartners);
        et3 = (EditText)findViewById(R.id.smokes);
        et4 = (EditText)findViewById(R.id.smokespack);
        et5 = (EditText)findViewById(R.id.hormonalyears);
        et6 = (EditText)findViewById(R.id.iudyears);
        et7 = (EditText)findViewById(R.id.stdsnumber);


          /*

          Feature Importance Result from Boruta:

        ##                                    boruta_analysis$finalDecision
## Age                                                    Tentative
## Number.of.sexual.partners                              Confirmed
## First.sexual.intercourse                                Rejected
## Num.of.pregnancies                                      Rejected
## Smokes                                                  Rejected
## Smokes..years.                                         Confirmed
## Smokes..packs.year.                                    Confirmed
## Hormonal.Contraceptives                                Confirmed
## Hormonal.Contraceptives..years.                        Confirmed
## IUD                                                    Confirmed
## IUD..years.                                            Confirmed
## STDs                                                   Tentative
## STDs..number.                                          Confirmed
## STDs.condylomatosis                                    Confirmed
## STDs.cervical.condylomatosis                           Tentative
## STDs.vaginal.condylomatosis                             Rejected
## STDs.vulvo.perineal.condylomatosis                     Confirmed
## STDs.syphilis                                          Confirmed
## STDs.pelvic.inflammatory.disease                        Rejected
## STDs.genital.herpes                                     Rejected
## STDs.molluscum.contagiosum                              Rejected
## STDs.AIDS                                              Tentative
## STDs.HIV                                                Rejected
## STDs.Hepatitis.B                                       Tentative
## STDs.HPV                                                Rejected
## STDs..Number.of.diagnosis                              Tentative
## STDs..Time.since.first.diagnosis                       Confirmed
## STDs..Time.since.last.diagnosis                        Confirmed
## Dx.Cancer                                              Confirmed
## Dx.CIN                                                 Tentative
## Dx.HPV                                                 Confirmed
## Dx                                                     Confirmed
        */


        predict = (Button)findViewById(R.id.btnSubmit);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int ck=1;
                try {
                    String age = et1.getText().toString();
                    if(age.isEmpty())age="0";
                    int Age = Integer.parseInt(age);

                    String sexpartners = et2.getText().toString();
                    if(sexpartners.isEmpty())sexpartners="0";

                    if(sexpartners.equals("blank")) {
                        String sexpartnerss="0";
                    }
                    int Sexpartners = Integer.parseInt(sexpartners);


                    String smokesyear = et3.getText().toString();
                    if(smokesyear.isEmpty())smokesyear="0";
                    int Smokes = Integer.parseInt(smokesyear);

                    String smokespacks = et4.getText().toString();
                    if(smokespacks.isEmpty())smokespacks="0";
                    int Smokespack = Integer.parseInt(smokespacks);

                    String hermonalcontrayears = et5.getText().toString();
                    if(hermonalcontrayears.isEmpty())hermonalcontrayears="0";
                    int Hormonalyears = Integer.parseInt(hermonalcontrayears);

                    String iudyears = et6.getText().toString();
                    if(iudyears.isEmpty())iudyears="0";
                    int Iudyears = Integer.parseInt(iudyears);

                    String stdsnumber = et7.getText().toString();
                    if(stdsnumber.isEmpty())stdsnumber="0";
                    int Stdsnumber = Integer.parseInt(stdsnumber);


                    if(TextUtils.isEmpty(et1.getText().toString()) || (Age < 13 || Age > 84 )){
                        et1.setError("please provide your Age ranging between 13-84");
                        et1.requestFocus();
                    }

                    if(TextUtils.isEmpty(et2.getText().toString()) || (Sexpartners < 1 || Sexpartners > 28 )){
                        et2.setError("please input number of sexual partners  ranging between 1-28");
                        et2.requestFocus();
                    }

                    if(TextUtils.isEmpty(et3.getText().toString()) || (Smokes < 0 || Smokes > 37 )){
                        et3.setError("please input for smokes  ranging between 0-37");
                        et3.requestFocus();
                    }

                    if(TextUtils.isEmpty(et4.getText().toString()) || (Smokespack < 0 || Smokespack > 37 )){
                        et4.setError("please input smokes(packs/years)  ranging between 0-37");
                        et4.requestFocus();
                    }

                    if(TextUtils.isEmpty(et5.getText().toString()) || (Hormonalyears < 0 || Hormonalyears > 30 )){
                        et5.setError("please input for hormonal contraceptives(years)  ranging between 0-30");
                        et5.requestFocus();
                    }

                    if(TextUtils.isEmpty(et6.getText().toString()) || (Iudyears < 0 || Iudyears > 19 )){
                        et6.setError("please input for IUD(years)  ranging between 0-19");
                        et6.requestFocus();
                    }

                    if(TextUtils.isEmpty(et7.getText().toString()) || (Stdsnumber < 0 || Stdsnumber > 4 )){
                        et7.setError("please input for STDs(numbers) ranging between 0-4");
                        et7.requestFocus();
                    }




                    //Getting Radio Button Inputs



                    radiogroup = (RadioGroup) findViewById(R.id.radiocervix);
                    radiogroup1 = (RadioGroup) findViewById(R.id.radiocervix1);
                    radiogroup2 = (RadioGroup)findViewById(R.id.radiocervix2);
                    radiogroup3 = (RadioGroup) findViewById(R.id.radiocervix3);
                    radiogroup4 = (RadioGroup) findViewById(R.id.radiocervix4);
                    radiogroup5 = (RadioGroup) findViewById(R.id.radiocervix5);
                    radiogroup6 =(RadioGroup) findViewById(R.id.radiocervix6);
                    radiogroup7 = (RadioGroup)findViewById(R.id.radiocervix7);
                    radiogroup8 = (RadioGroup) findViewById(R.id.radiocervix8);
                    radiogroup9 = (RadioGroup)findViewById(R.id.radiocervix9);
                    radiogroup10 = (RadioGroup)findViewById(R.id.radiocervix10);
                    radiogroup11 =(RadioGroup) findViewById(R.id.radiocervix11);
                    radiogroup12 = (RadioGroup)findViewById(R.id.radiocervix12);
                    radiogroup13 = (RadioGroup)findViewById(R.id.radiocervix13);

                    int radiobutton,radiobutton1,radiobutton2,radiobutton3,radiobutton4,radiobutton5,radiobutton6,radiobutton7,radiobutton8,radiobutton9,radiobutton10,radiobutton11,radiobutton12,radiobutton13;

                    radiobutton = radiogroup.getCheckedRadioButtonId();

                    radiobutton1 = radiogroup1.getCheckedRadioButtonId();
                    radiobutton2 = radiogroup2.getCheckedRadioButtonId();
                    radiobutton3 = radiogroup3.getCheckedRadioButtonId();
                    radiobutton4 = radiogroup4.getCheckedRadioButtonId();
                    radiobutton5 = radiogroup5.getCheckedRadioButtonId();
                    radiobutton6 = radiogroup6.getCheckedRadioButtonId();
                    radiobutton7 = radiogroup7.getCheckedRadioButtonId();
                    radiobutton8 = radiogroup8.getCheckedRadioButtonId();
                    radiobutton9 = radiogroup9.getCheckedRadioButtonId();
                    radiobutton10 = radiogroup10.getCheckedRadioButtonId();
                    radiobutton11 = radiogroup11.getCheckedRadioButtonId();
                    radiobutton12 = radiogroup12.getCheckedRadioButtonId();
                    radiobutton13 = radiogroup13.getCheckedRadioButtonId();


                    radioButton = (RadioButton)findViewById(radiobutton);

                    String hermonalcontra = radioButton.getText().toString();
                    if(hermonalcontra.equals("blank"))hermonalcontra = "99";

                    radioButton = (RadioButton)findViewById(radiobutton1);

                    String iud = radioButton.getText().toString();
                    if(iud.equals("blank"))iud = "99";

                    radioButton = (RadioButton)findViewById(radiobutton2);

                    String stds = radioButton.getText().toString();
                    if(stds.equals("blank"))stds = "99";

                    radioButton = (RadioButton)findViewById(radiobutton3);

                    String stdscondy = radioButton.getText().toString();
                    if(stdscondy.equals("blank"))stdscondy = "99";

                    radioButton = (RadioButton)findViewById(radiobutton4);

                    String stdscervicalcondy = radioButton.getText().toString();
                    if(stdscervicalcondy.equals("blank"))stdscervicalcondy = "99";

                    radioButton = (RadioButton)findViewById(radiobutton5);

                    String vulbo = radioButton.getText().toString();
                    if(vulbo.equals("blank"))vulbo = "99";

                    radioButton = (RadioButton)findViewById(radiobutton6);

                    String syphills = radioButton.getText().toString();
                    if(syphills.equals("blank"))syphills = "99";

                    radioButton = (RadioButton)findViewById(radiobutton7);

                    String aids = radioButton.getText().toString();
                    if(aids.equals("blank"))aids = "99";

                    radioButton = (RadioButton)findViewById(radiobutton8);

                    String hepatisb = radioButton.getText().toString();
                    if(hepatisb.equals("blank"))hepatisb = "99";

                    radioButton = (RadioButton)findViewById(radiobutton9);

                    String ndx = radioButton.getText().toString();

                    radioButton = (RadioButton)findViewById(radiobutton10);

                    String dxcancer = radioButton.getText().toString();

                    radioButton = (RadioButton)findViewById(radiobutton11);

                    String cin = radioButton.getText().toString();

                    radioButton = (RadioButton)findViewById(radiobutton12);

                    String dxhpv = radioButton.getText().toString();

                    radioButton = (RadioButton)findViewById(radiobutton13);

                    String dx = radioButton.getText().toString();

                    //Toast.makeText(MainActivity.this, "tapped: " + radio , Toast.LENGTH_LONG).show();




                    //applying classifier


                    Classifier cls = null;


                    cls = (Classifier) read(getAssets().open("rf.model"));


                    ArrayList<Attribute> attributes = new ArrayList<>();




                    attributes.add(new Attribute("a",Arrays.asList("13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
                            "31","32","33", "34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56",
                            "57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84"
                    ),0));

                    attributes.add(new Attribute("b",Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28", "99"),1));

                    attributes.add(new Attribute("c",Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
                            "27","28","29","30", "31","32","33", "34","35","36","37", "99"),2));

                    attributes.add(new Attribute("d", Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
                            "27","28","29","30", "31","32","33", "34","35","36","37", "99"),3));

                    attributes.add(new Attribute("e",Arrays.asList("no","yes", "99" ),4));

                    attributes.add(new Attribute("f",Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
                            "27","28","29","30", "99"),5));

                    attributes.add(new Attribute("g",Arrays.asList("yes","no", "99"),6));

                    attributes.add(new Attribute("h",Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19", "99"),7));

                    attributes.add(new Attribute("i",Arrays.asList("yes","no", "99"),8));

                    attributes.add(new Attribute("j",Arrays.asList("0","1","2","3","4", "99"),9));


                    attributes.add(new Attribute("k",Arrays.asList("yes","no", "99"),10));

                    attributes.add(new Attribute("l",Arrays.asList("no","yes", "99"),11)); //yes

                    attributes.add(new Attribute("m",Arrays.asList("yes","no", "99"),12));

                    attributes.add(new Attribute("n",Arrays.asList("yes","no", "99"),13));

                    attributes.add(new Attribute("o",Arrays.asList("no","yes", "99"),14));//yes

                    attributes.add(new Attribute("p",Arrays.asList("yes","no", "99"),15));

                    attributes.add(new Attribute("q",Arrays.asList("zero","one","two","three"),16));

                    attributes.add(new Attribute("r",Arrays.asList("yes","no"),17));

                    attributes.add(new Attribute("s",Arrays.asList("yes","no"),18));

                    attributes.add(new Attribute("t",Arrays.asList("yes","no"),19));

                    attributes.add(new Attribute("u",Arrays.asList("yes","no"),20));


                    attributes.add(new Attribute("biopsy",Arrays.asList("yes","no"),21));




                    // new instance to classify. Class label should be "no"
                    Instance instance = new SparseInstance(21);

                    instance.setValue(attributes.get(0), age);

                    instance.setValue(attributes.get(1), sexpartners);

                    instance.setValue(attributes.get(2), smokesyear);


                    instance.setValue(attributes.get(3), smokespacks);


                    instance.setValue(attributes.get(4), hermonalcontra);


                    instance.setValue(attributes.get(5), hermonalcontrayears);


                    instance.setValue(attributes.get(6), iud);


                    instance.setValue(attributes.get(7), iudyears);


                    instance.setValue(attributes.get(8), stds);


                    instance.setValue(attributes.get(9), stdsnumber);

                    instance.setValue(attributes.get(10), stdscondy);


                    instance.setValue(attributes.get(11), stdscervicalcondy);


                    instance.setValue(attributes.get(12), vulbo);


                    instance.setValue(attributes.get(13), syphills);

                    instance.setValue(attributes.get(14), aids);

                    instance.setValue(attributes.get(15), hepatisb);

                    instance.setValue(attributes.get(16), ndx);

                    instance.setValue(attributes.get(17), dxcancer);

                    instance.setValue(attributes.get(18), cin);

                    instance.setValue(attributes.get(19), dxhpv);

                    instance.setValue(attributes.get(20), dx);
                    //instance.setValue(attributes.get(30), biopsy);



                    // Create an empty set
                    Instances datasetConfiguration;
                    datasetConfiguration = new Instances("cervix.symbolic", attributes, 0);

                    datasetConfiguration.setClassIndex(21);
                    instance.setDataset(datasetConfiguration);

                    double[] distribution;
                    distribution = cls.distributionForInstance(instance);

                    // print results

                    Toast.makeText(cervicalcancer.this, "predicted probability(yes): " + String.valueOf(distribution[0] * 100) + "%", Toast.LENGTH_LONG).show();

                    Toast.makeText(cervicalcancer.this, "predicted probability(no): " + String.valueOf(distribution[1] * 100) + "%", Toast.LENGTH_LONG).show();




                    if((distribution[0] * 100) > 50)
                        Toast.makeText(cervicalcancer.this, "Please Approach Nearby Doctor/cervical cancer specialist For Treatment!!!" , Toast.LENGTH_LONG).show();



                }catch (NumberFormatException e){
                    e.printStackTrace();
                    Toast.makeText(cervicalcancer.this, "Error: " + String.valueOf(e) , Toast.LENGTH_LONG).show();
                }catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }

}
