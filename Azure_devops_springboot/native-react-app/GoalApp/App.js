import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, ScrollView, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {
  const [enteredGoalText,setEnteredGoalText]=useState('');
  const [goalList,setGoalList]=useState([]);
  function goalInputHandler(enteredText){
    setEnteredGoalText(enteredText);

  }
  function addGoalHandler(){
    /**
     * it will current goal to the existing goal
     */
    setGoalList((addGoalList)=>[
      ...addGoalList,enteredGoalText,]);
    console.log(enteredGoalText);
  }
  return (
    <View style={styles.appContainer}>
   <View style={styles.inputContainer}>
    <TextInput  style={styles.textInput} placeholder='Your course Goal' onChangeText={goalInputHandler}/>
    <Button title='Add Goal!' onPress={addGoalHandler}/>
   </View>
   <View style={styles.goalContainer}>
   <ScrollView>
   {goalList.map((goal,index)=>
    <View key={index} style={styles.goalItem}>
      <Text style={styles.goalText} >{goal}</Text>
      </View>
   )}
   </ScrollView>
   </View>
   </View>
  );
}

const styles = StyleSheet.create({
 appContainer:{
  flex:1,
  padding:50,
  paddingHorizontal:16
 },
 inputContainer:{
  flex:1,
  flexDirection:'row',
  justifyContent:'space-between',
  alignItems:'center',
  marginBottom:24,
  borderBottomWidth:1,
  borderBottomColor:'#cccccc'
 },
 textInput:{
  borderWidth:1,
  borderColor:'#cccccc',
  width:'80%',
  marginRight:8,
  padding:8
 },
 goalContainer:{
  flex:5
 },
 goalItem:{
  margin:8,
  padding:8,
  borderRadius:6,
  backgroundColor:'#5e0acc'
 },
 goalText:{
  color:'white'
 }
});
