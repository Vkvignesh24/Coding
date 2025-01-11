import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score, classification_report

df = pd.read_csv('tennis_data.csv')

df_encoded = pd.get_dummies(df, columns=['Outlook', 'Temperature', 'Humidity', 'Windy'])

X = df_encoded.drop('Play Tennis', axis=1)
y = df_encoded['Play Tennis']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

nb_classifier = GaussianNB()
nb_classifier.fit(X_train, y_train)

y_pred = nb_classifier.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

print("Classification Report:")
print(classification_report(y_test, y_pred))

new_instance = pd.DataFrame({'Outlook_Overcast': [0], 'Outlook_Rainy': [1], 'Outlook_Sunny': [0],
                             'Temperature_Cool': [0], 'Temperature_Hot': [0], 'Temperature_Mild': [1],
                             'Humidity_High': [1], 'Humidity_Normal': [0],
                             'Windy_False': [0], 'Windy_True': [1]})

prediction = nb_classifier.predict(new_instance)
print("Prediction:", prediction[0])
