import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
const styles1 = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
export const HomeComponent=()=>{
  return (
    <View
      style={{
        flexDirection: 'row',
        height: 100,
        padding: 20,
      }}>
      <View style={{backgroundColor: '#ffcc99', flex: 1}} />
      <Text>Welcome to SGI Ireland</Text>
    </View>
  );
}

