package view.clubAssociate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.ClubAssociate;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A method that handles the list of all Club Associates that is displayed in the ClubAssociateListView (FXML File) and
 * list of Members.
 *
 * @author Julia Gramovicha
 * @version 1.0 - 03 December 2022
 */
public class ClubAssociateListViewModel implements Serializable
{
  private ObservableList<ClubAssociateViewModel> list;
  private ObservableList<ClubAssociateViewModel> listOfMembers;
  private BoardGamesModel model;

  /**
   * 1-argument constructor creating the observableArrayList of all Club Associates and observableArrayList of
   * Members and updating both of them.
   *
   * @param model
   *        the current model of board games system
   */
  public ClubAssociateListViewModel(BoardGamesModel model)
  {
    this.model=model;
    this.list = FXCollections.observableArrayList();
    this.listOfMembers = FXCollections.observableArrayList();
    update();
    updateMembers();
  }
  /**
   * A method that returns the list of Club Associates displayed.
   *
   * @return observableList
   *        the list of Club Associates displayed in the view.
   */
  public ObservableList<ClubAssociateViewModel> getList() {
    return list;
  }
  /**
   * A method that returns the list of Members.
   *
   * @return observableList
   *        the list of Members displayed in the view.
   */
  public ObservableList<ClubAssociateViewModel> getListOfMembers() {
    return listOfMembers;
  }
  /**
   * A method that clears the observableList and updates it with all Club Associates from the model.
   *
   */
  public void update(){
    list.clear();
    ArrayList<ClubAssociate> clubAssociates = model.getAllClubAssociates();
    for (ClubAssociate clubAssociate : clubAssociates) // for each loop
      list.add(new ClubAssociateViewModel(clubAssociate));
  }
  /**
   * A method that clears the observableList and updates it with all Members from the model.
   *
   */
  public void updateMembers(){
    listOfMembers.clear();
    ArrayList<ClubAssociate> clubAssociates = model.getAllClubAssociates();
    for(int i=0;i< clubAssociates.size();i++){
      if(clubAssociates.get(i).isMember()==true){
        listOfMembers.add(new ClubAssociateViewModel(clubAssociates.get(i)));
      }
    }
  }
  /**
   * A method that takes the Club Associate and adds it to observableList as a conversion of ClubAssociateViewModel
   *
   * @param clubAssociate
   *        the instance of the Club Associate that is to be added to observableList of Club Associates.
   */
  public void add(ClubAssociate clubAssociate) {
    list.add(new ClubAssociateViewModel(clubAssociate));
  }
}
