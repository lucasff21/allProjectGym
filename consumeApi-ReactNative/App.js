import 'react-native-gesture-handler';
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { StyleSheet, Text, View } from 'react-native';
import ExerciseList from './src/components/ExerciseList';
import ExerciseForm from './src/components/ExerciseForm';
import { Button, Icon } from '@rneui/base';

const Stack = createStackNavigator();


const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='ExerciseList'>
        <Stack.Screen name="ExerciseList" component={ExerciseList} options={({navigation}) => {
              return {
                title: 'Lista de usuarios',
                headerRight: () => (
                  <Button
                    onPress={() => navigation.navigate('ExerciseForm')}
                    type="clear"
                    icon={<Icon name="add" size={25} color="black" />}
                  />
                ),
              };
            }}> 
          </Stack.Screen>
        <Stack.Screen name="ExerciseForm" component={ExerciseForm} options={{title: 'Formulário de Exercício'}}></Stack.Screen>
      </Stack.Navigator>
    </NavigationContainer>

   
  );
}

export default App;


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
