import React, { useEffect, useState } from "react";
import {
  View,
  TextInput,
  Button,
  StyleSheet,
  SafeAreaView,
  Alert,
  TouchableOpacity
} from "react-native";
import apiUrl from "../services/api";
import DateTimePicker from '@react-native-community/datetimepicker';
import Icon from 'react-native-vector-icons/FontAwesome';

const ExerciseForm = ({ route, navigation }) => {
  const { exercise } = route.params || {};
  const [id, setId] = useState(exercise ? exercise.id : null);
  const [grupoMuscular, setGrupoMuscular] = useState(exercise ? exercise.grupo_muscular : '');
  const [series, setSeries] = useState(exercise ? String(exercise.series) : '');
  const [repeticoes, setRepeticoes] = useState(exercise ? String(exercise.repeticoes) : '');
  const [peso, setPeso] = useState(exercise ? String(exercise.peso) : '');
  const [observacao, setObservacao] = useState(exercise ? exercise.observacao : '');
  const [data, setData] = useState(exercise ? new Date(exercise.data) : new Date());
  const [showDatePicker, setShowDatePicker] = useState(false);

  useEffect(() => {
    if (exercise) {
      setId(exercise.id);
      setGrupoMuscular(exercise.grupo_muscular);
      setSeries(String(exercise.series));
      setRepeticoes(String(exercise.repeticoes));
      setPeso(String(exercise.peso));
      setObservacao(exercise.observacao);
      setData(new Date(exercise.data));
    }
  }, [exercise]);

  const objectExercise = {
    id, // Incluindo o campo id
    grupo_muscular: grupoMuscular,
    series,
    repeticoes,
    peso,
    observacao,
    data: data.toISOString().split('T')[0] // Formatar data corretamente
  };

  const onSubmit = async () => {
    try {
      if (id) {
        await apiUrl.put(`/exercicio/${id}`, objectExercise);
        console.warn(objectExercise);
      } else {
        console.warn('SEM ID');
        await apiUrl.post('/exercicio', objectExercise);
      }
      Alert.alert("Sucesso", "Exercício salvo com sucesso!");
      navigation.navigate('ExerciseList');
    } catch (error) {
      Alert.alert("Erro", "Falha ao salvar exercício.");
      console.error("Erro ao salvar exercício:", error);
    }
  };

  const backPage = () => {
    navigation.navigate('ExerciseList');
  };

  const handleDateChange = (event, selectedDate) => {
    const currentDate = selectedDate || data;
    setShowDatePicker(false);
    setData(currentDate);
  };

  const showDatePickerModal = () => {
    setShowDatePicker(true);
  };

  return (
    <SafeAreaView style={styles.form}>
      <TextInput
        style={styles.input}
        onChangeText={setGrupoMuscular}
        value={grupoMuscular}
        placeholder="Grupo Muscular:"
      />
      <TextInput
        style={styles.input}
        onChangeText={setSeries}
        value={series}
        placeholder="Séries:"
        keyboardType="numeric"
      />
      <TextInput
        style={styles.input}
        onChangeText={setRepeticoes}
        value={repeticoes}
        placeholder="Repetições:"
        keyboardType="numeric"
      />
      <TextInput
        style={styles.input}
        onChangeText={setPeso}
        value={peso}
        placeholder="Peso:"
        keyboardType="numeric"
      />
      <TextInput
        style={styles.input}
        onChangeText={setObservacao}
        value={observacao}
        placeholder="Observações:"
      />
      <View style={styles.datePickerContainer}>
        <TextInput
          style={styles.dateInput}
          value={data.toLocaleDateString()}
          placeholder="Selecione a Data"
          onFocus={showDatePickerModal}
          editable={false}
        />
        <TouchableOpacity onPress={showDatePickerModal} style={styles.icon}>
          <Icon name="calendar" size={24} color="#000" />
        </TouchableOpacity>
      </View>
      {showDatePicker && (
        <DateTimePicker
          value={data || new Date()}
          mode="date"
          display="default"
          onChange={handleDateChange}
        />
      )}
      <View style={styles.buttonContainer}>
        <Button style={styles.button} title="Salvar" onPress={onSubmit} />
        <Button style={styles.button} title="Voltar" onPress={backPage} />
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  form: {
    padding: 12
  },
  input: {
    height: 40,
    borderWidth: 1,
    margin: 8,
    padding: 10
  },
  button: {
    flex: 1,
    marginHorizontal: 10
  },
  buttonContainer: {
    flexDirection: 'row',
    justifyContent: 'space-evenly',
    marginTop: 20
  },
  datePickerContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    margin: 8,
    position: 'relative'
  },
  dateInput: {
    flex: 1,
    height: 40,
    borderWidth: 1,
    padding: 10
  },
  icon: {
    position: 'absolute',
    right: 10,
    padding: 10
  }
});

export default ExerciseForm;
