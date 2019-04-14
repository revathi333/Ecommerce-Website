package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.SaveForLater;

public interface SaveForLaterDAO
{
	public boolean addSavedItem(SaveForLater savedItem);
	public SaveForLater getSavedItem(int savedItemId);
	public boolean deleteSavedItem(SaveForLater savedItem);
	public List<SaveForLater> savedItemsList(String username);

}

