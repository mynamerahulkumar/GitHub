import { Pressable, StyleSheet, Text, View } from "react-native";

function GoalItem(props){
   return(
    <View  style={styles.goalItem}>
    <Pressable android_ripple={{color:'#dddddd'}} onPress={props.deleteGoalItem.bind(this,props.id)}>
    <View>
    <Text style={styles.goalText}>{props.text}</Text>
   </View>
  </Pressable>
  </View>
   )
}

export default GoalItem;

const styles=StyleSheet.create({
    goalItem:{
        margin:8,
        borderRadius:6,
        backgroundColor:'#5e0acc'
       },
       goalText:{
        color:'white',
        padding:8,
       }
})