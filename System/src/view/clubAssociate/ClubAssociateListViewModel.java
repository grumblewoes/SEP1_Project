package view.clubAssociate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.ClubAssociate;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * 
 * 
 * @author 
 * @version 
 */
public class ClubAssociateListViewModel implements Serializable
{
  private ObservableList<ClubAssociateViewModel> list;
  private BoardGamesModel model;


  /**
   * 1-argument constructor 
   * 
   * 
   * @param model 
   *        
   */
  public ClubAssociateListViewModel(BoardGamesModel model)
  {
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }
  /**
   * 
   * 
   *
   * @return 
   *        
   */
  public ObservableList<ClubAssociateViewModel> getList() {
    return list;
  }

  /**
   * 
   * 
   */
  public void update(){
    list.clear();
    ArrayList<ClubAssociate> clubAssociates = model.getAllClubAssociates();
    for (ClubAssociate clubAssociate : clubAssociates)
      list.add(new ClubAssociateViewModel(clubAssociate));
  }
  /**
   * 
   * 
   * @param clubAssociate 
   *        
   */
  public void add(ClubAssociate clubAssociate) {
    list.add(new ClubAssociateViewModel(clubAssociate));

  }

}
