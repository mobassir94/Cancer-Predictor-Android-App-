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
 
click here : https://github.com/mobassir94/Cancer-Predictor-Android-App-/blob/master/risk%20score.JPG


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







