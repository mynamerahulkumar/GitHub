import { useState } from "react";
import { Button, Image, Modal, StyleSheet, TextInput, View } from "react-native";

function GoalInput(props){
    const [enteredGoalText,setEnteredGoalText]=useState('');

    function goalInputHandler(enteredText){
      setEnteredGoalText(enteredText);
  
    }
    function addGoalHandler(){
        props.onAddGoal(enteredGoalText);
        setEnteredGoalText('');
    }
return (
    <Modal visible={props.visible} animationType="slide">
        <View style={styles.inputContainer}>
            <Image source={require('../assets/images/goal.png')} style={styles.image}></Image>
            <TextInput  style={styles.textInput} 
                placeholder='Your course Goal' 
                onChangeText={goalInputHandler} 
                value={enteredGoalText}/>
            <View style={styles.buttonContainer} >
                <View style={styles.button}>
                    <Button title='Add Goal!' onPress={addGoalHandler} color='#5e0acc'/>
                </View>
                <View style={styles.button}>
                    <Button title="Cancel" onPress={props.onCancel} color='#f31282'></Button>
                </View>
        </View>
   </View>
   </Modal>);
}

export default GoalInput;

const styles=StyleSheet.create({
    inputContainer:{
        flex:1,
        justifyContent:'space-between',
        alignItems:'center',
        marginBottom:24,
        borderBottomWidth:1,
        borderBottomColor:'#cccccc',
        backgroundColor:'#002b80'
       },
       textInput:{
        borderWidth:1,
        borderColor:'#cccccc',
        width:'80%',
        marginRight:8,
        padding:8
       },
       buttonContainer:{
        marginTop:16,
        flexDirection:'row'
       },
       button:{
        width:100,
        marginHorizontal:8
       },
       image:{
        width:100,
        height:100,
        margin:20,
       },
})