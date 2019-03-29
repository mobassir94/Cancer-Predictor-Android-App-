# Cancer-Predictor-Android-App-
Using Weka API This System Is developed for early detecting ovarian cancer and cervical cancer of a patient and to recommend when to approach nearby doctor for treatment, before they completely develop cancer.

# Ovarian Cancer Predictor:

521 cancer and non-cancer patients record was collected from different diagnostic centers (in Bangladesh). Then a structured questionnaire was used containing details of ovarian cancer risk factors including age, menopause end age, problem during pregnancy, first sex age, any infection in genital area, affected by ovarian cancer, abortion, pregnancy, BMI, menopause after 50, food habit, obesity, excessive alcohol, late menopause, early menopause, hormone therapy, exercise, previous exposure to other sexually transmitted infections (STIs), marital status, genetic risk, outdoor activities and affected by any cancer before based on the previous studies. After pre-processing, data was clustered using K-means clustering algorithm for identifying relevant and non-relevant data to ovarian cancer. Then relevant data were used to develop this system, there are 6 algorithms applied in the relevant data, which are:

1. Decision Tree (J48):  accuracy = 80.2548 %
2. Random Forest:  accuracy = 80.2548 %
3. Logistic Model Trees (LMT):  accuracy = 82.1656 %
4. Naïve Bayes:  accuracy = 75.7962 %
5. Logistic Regression:  accuracy = 80.8025 %
6. Support Vector Machines (SVM):  accuracy = 80.8917 %

# Risk Score Generation Process: 

Below is the table which was generated from the dataset that shows each and every features percentage/distribution of developing ovarian cancer (yes/no)
 


                                   Affected by ovarian Cancer?

                                         yes	         no
Menarche start early?
	early	                               84(64.122%	   47(35.877%)
	normal	                             2(1.62%)	   121(98.37%)
	late	                               181(67.79%)	  86(32.209%)
Oral Contraception?
	yes	                                 72(92.30%)	    6(7.69%)
	no	                                 195(44.01%)	  248(55.98%)
Diet Maintaining?
	yes	                                 14(10%)	      126(90%)
	no	                                 253(66.40%)	  128(33.59%)
Affected By Breast Cancer?
	yes	                                 250(70.42%)  	105(29.57%)
	no	                                 17(10.24%)	    149(89.75%)
Affected By cervical Cancer?
	yes	                                 258(68.98%)	  116(31.01%)
	no	                                 9(6.122%)	    138(93.87%)
Cancer History In family?
	yes	                                 241(68.85%)	  109(31.14%)
	no	                                 26(15.20%)    	145(84.79%)
Education?
	illitarate	                         172(66.40%)  	87(33.59%)
	primary level	                       90(37.65%)	    149(62.34%)
	graduated	                           5(21.73%)	    18(78.26%)
Age of Husband?
	below 30	                           7(58.33%)	    5(41.66%)
	31-45	                               5(9.09%)	      50(90.90%)
	46-60	                               243(55.86%)	  192(44.13%)
	above 60	                           12(63.15%)	    7(36.84%)
Menopause End age?
	before 40	                           70(47.29%)	    78(52.70%)
	40-51	                               48(28.91%)	    118(71.08%)
	after 52	                           149(71.98%)	  58(28.01%)
Food contains high fat?
	yes	                                 97(87.38%)	    14(12.61%)
	no	                                 170(41.46%)	  240(58.53%)
Abortion?
	yes	                                 219(85.21%)	  38(14.78%)
	no	                                 48(18.18%)	    216(81.81%)
  


From the above table manual rating was given to each sub feature based on their impact on developing ovarian cancer.
For example  the feature “Menarche Starts Early” has 3 features early, late and normal, we can see that 64% time patients has developed ovarian cancer whose menarche starts “early” and only 35% patients haven’t developed ovarian cancer whose menarche starts early, so we give higher score to sub feature “early” because it is more likely “risky symptom” of a patient.

# Here is the Manual Risk scoring Table:
1st column: "Menarche start early" 
                       Early - 2
                       Normal - 1
                        Late - 3

2nd column: "Oral Contraception" 
                        Yes – 3 
                        No - 1 

3rd column: "Diet Maintain" 
                        Yes - 1
                         No - 2
4th column: "Affected by Breast Cancer" 
                         Yes - 3
                          No - 1
5th column: "Affected By cervical Cancer?" 
                         Yes - 3 
                          No - 1
6th column: "Cancer History In family?" 
                          Yes - 2
                          No - 1
7th column: "Education?"
                       Illiterate - 3
                       Primary level - 1
                       Graduated - 1
 8th column: "Age of Husband" 
                          Below 30 - 2
                           31-45 – 1 
                          46-60 – 4 
                       Above 60 - 3
9th column: "Menopause End age?" 
                       Before 40 - 2
                       40-51 - 1
                      After 52 - 3
10th column: "Food contains high fat?"
                         Yes - 3
                         No - 1
 11th column: "Abortion?" 
                        Yes - 3
                         No – 1

This system then checks which sub features user selects and sums up all manual scoring rates, if total score for the patient is less than 18, the system shows “low risk”, if total score is greater than 17 and less than 25 then the system shows “medium risk” and if the total score is greater than 24 then the system shows “high risk” status of the patient. 
The system checks if 3 or more algorithms/classifier returns positive prediction over 50% then the system gives the patient a warning by saying “Please Consult a Doctor As Soon as Possible”



# Cervical Cancer Predictor:

the Dataset was collected from UCI machine learning repository, only 1 algorithm used for predicting cervical cancer which is Random Forest, and on a 70-30% training and testing split and using 10 fold cross validation the accuracy of this algorithm on this system was 89.5349 % that means almost 90% time what this system predicts for ‘biopsy’ is correct (based on previous patients symptoms)







