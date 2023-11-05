import { coach } from "./CoachInterfact";

export class GolfCoach implements coach{
    getCoachInfo(): string {
        return "I am golf coach";
    }

}