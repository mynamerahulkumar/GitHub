import { coach } from "./CoachInterfact";
import { CricketCoach } from "./CricketCoach";
import { GolfCoach } from "./GolfCoach";

let myGolfCoach=new GolfCoach();
let cricketCoach=new CricketCoach();
let coaches:coach[]=[];
coaches.push(myGolfCoach);
coaches.push(cricketCoach);
for(let coach of coaches){
    console.log(coach.getCoachInfo())
}