import React, { useEffect, useState, useCallback } from "react";
import { View, Text, FlatList, TouchableOpacity, StyleSheet } from "react-native";
import Api from "../services/api";
import { useFocusEffect } from '@react-navigation/native';
import Icon from "react-native-vector-icons/FontAwesome";
import { Button, ListItem } from "@rneui/base";

const ExerciseList = ({ navigation }) => {
  const [exercises, setExercises] = useState([]);

  const fetchExercises = async () => {
    try {
      const response = await Api.get(`/exercicio`);
      setExercises(response.data);
    } catch (error) {
      console.error("Erro ao buscar exercícios:", error);
    }
  };

  useFocusEffect(
    useCallback(() => {
      fetchExercises();
    }, [])
  );

  const deleteExercise = async (id) => {
    try{
      await Api.delete(`/exercicio/${id}`)
      fetchExercises();
    } catch(error) {
      console.error("Erro ao deletar exercício:", error);
    }
  }

  const editExercise = async (id) => {
    try {
      const response = await Api.get(`/exercicio/${id}`)
      navigation.navigate('ExerciseForm', { exercise: response.data });
    }catch(error) {
      console.error("Erro ao encontrar exercícios:", error);
      console.error("Erro ao encontrar exercícios:", error);
    }
  }

  const renderItem = ({ item }) => {
    return (
      <ListItem style={styles.item}>
        <Text>{item.grupo_muscular} |</Text>
        <Text> {item.series} séries de {item.repeticoes} repetições </Text>
        <View style={styles.actionsForm}>
          <Button
            onPress={() => editExercise(item.id)}
            type="clear"
            icon={<Icon name="edit" size={25} color="orange" />}
          />
          <Button
            onPress={() => deleteExercise(item.id)}
            type="clear"
            icon={<Icon name="delete" size={25} color="red" />}
          />
        </View>
      </ListItem>
    );
  };

  return (
    <View>
      <FlatList
        data={exercises}
        keyExtractor={(item) => String(item.id)}
        renderItem={renderItem}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  item: {
    padding: 10,
    borderBottomWidth: 1,
    borderBottomColor: "#ccc",
  },
  actionsForm: {
    flexDirection: "row",
  },
});

export default ExerciseList;
