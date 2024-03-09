import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, FlatList, ScrollView, StyleSheet, Text, TextInput, View } from 'react-native';
import GoalItem from './components/GoalItem';
import GoalInput from './components/GoalInput';

export default function App() {
  const [goalList,setGoalList]=useState([]);
  const [modalVisible,setModelVisible]=useState(false);
  function startAddGoalHandler(){
    setModelVisible(true);
  }
  function cancelGoalHandler(){
    setModelVisible(false);
  }
  function addGoalHandler(enteredGoalText){
    /**
     * it will current goal to the existing goal
     */
    setGoalList((addGoalList)=>[
      ...addGoalList,
      {text:enteredGoalText,id:Math.random().toString()},]);
    console.log(enteredGoalText);
  }
  function deleteGoalHandler(id){
    setGoalList((addGoalList)=>{
      return addGoalList.filter(goal=>goal.id!=id);
    })
  }
  return (
    <View style={styles.appContainer}>
    <Button title='Add New Goal!' color='#009900' onPress={startAddGoalHandler}></Button>
   <GoalInput visible={modalVisible} onAddGoal={addGoalHandler} onCancel={cancelGoalHandler}></GoalInput>
   <View style={styles.goalContainer}>
  <FlatList data={goalList}
  renderItem={(itemData)=>{
    return(
      <GoalItem text={itemData.item.text} deleteGoalItem={deleteGoalHandler} id={itemData.item.id} />
    )
  }}

  >

  </FlatList>
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

 goalContainer:{
  flex:5
 },
 
});
