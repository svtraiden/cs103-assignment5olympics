/**
 * 
 */
package com.project5.dataManager;

import java.util.ArrayList;

import com.project5.dataElements.CurlerPlayer;
import com.project5.dataElements.CurlerPosition;

/**
 * @author Svetoslav Kostadinov
 *
 */
public class CurlerTeam {
	
	private static String teamName;
	private static ArrayList<CurlerPlayer> players;
	
	//constructor for curlerTeam
	public CurlerTeam(String countryName){
		CurlerTeam.teamName = countryName;
		players = new ArrayList<>();
	}
	
	public static int getNumPlayers() {
		int currentNumPlayers = players.size();
		return currentNumPlayers;
	}
	
	/**
	 * This Method adds player after validation
	 * 
	 * @param fName
	 * @param lName
	 * @param currentPosition
	 * @return String
	 */
	public static String addPlayer(String fName, String lName, CurlerPosition currentPosition) {
		if (getNumPlayers()<4) {
			switch (currentPosition) {
			case SKIP:
				if(getNumberOfPlayersAtThePosition(currentPosition) < 1){
					//CurlerPlayer addPlayer = new CurlerPlayer(fName, lName, position);
					players.add(new CurlerPlayer(fName, lName, currentPosition));
					return null;
				} else{
					return "There is already a skip on this team\nPlayer not added";
				}
			case THROWER:
				if(getNumberOfPlayersAtThePosition(currentPosition) < 1){
					players.add(new CurlerPlayer(fName, lName, currentPosition));
					return null;
				} else{
					return "There is already a thrower on this team\nPlayer not added";
				}
			case SWEEPER:
				if(getNumberOfPlayersAtThePosition(currentPosition) < 2){
					players.add(new CurlerPlayer(fName, lName, currentPosition));
					return null;
				} else{
					return "There are already 2 sweepers on this team\nPlayer not added";
				}
				default: 
					return "There was unexpected error /nPlease try again.";
			}
		}
		else {
			return "There are already 4 members on this team\nPlayer not added";
		}
		//System.out.println(getNumPlayers());
		
	}
	
	public static void createTeam(String countryName) {
		new CurlerTeam(countryName);
	}
	
	public static String printTeam(){
		String teamPrint = getTeamName()+"\n" ;
		for(CurlerPlayer player : players){
			teamPrint = teamPrint + player.getFirstName() + " " + player.getLastName() + ": " + player.getPosition() + "\n";
		}
		return teamPrint;
	}
	
	/**
	 * getNumberOfPlayersAtThePosition
	 * @param position
	 * @return int
	 * 
	 * This Methos substitutes the three fields given by specification
	 * numSweepers, numSkip and numThrowers
	 */
	public static int getNumberOfPlayersAtThePosition(CurlerPosition position) {
		int playersAtThePosition = 0;
		for (CurlerPlayer player : players) {
			switch (position) {
			case THROWER:
				if(player.getPosition().equals(CurlerPosition.THROWER))
					playersAtThePosition++;
				break;
			case SWEEPER: 
				if(player.getPosition().equals(CurlerPosition.SWEEPER))
					playersAtThePosition++;
				break;
			case SKIP: 
				if(player.getPosition().equals(CurlerPosition.SKIP))
					playersAtThePosition++;
				break;
			default:
					
			}
		}
		return playersAtThePosition ;
	}
	
	public static String getTeamName () {
		return teamName;
	}
	

	
}
