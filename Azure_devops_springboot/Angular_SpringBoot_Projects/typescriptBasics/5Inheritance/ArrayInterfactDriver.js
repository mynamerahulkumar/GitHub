"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var CricketCoach_1 = require("./CricketCoach");
var GolfCoach_1 = require("./GolfCoach");
var myGolfCoach = new GolfCoach_1.GolfCoach();
var cricketCoach = new CricketCoach_1.CricketCoach();
var coaches = [];
coaches.push(myGolfCoach);
coaches.push(cricketCoach);
for (var _i = 0, coaches_1 = coaches; _i < coaches_1.length; _i++) {
    var coach = coaches_1[_i];
    console.log(coach.getCoachInfo());
}
