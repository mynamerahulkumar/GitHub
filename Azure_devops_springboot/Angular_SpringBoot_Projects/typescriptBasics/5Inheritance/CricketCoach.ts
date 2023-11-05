import { coach } from "./CoachInterfact";

export class CricketCoach implements coach{
    getCoachInfo(): string {
        return "I am cricket coach"
    }

}
