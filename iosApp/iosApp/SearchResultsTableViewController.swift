//
//  SearchResultsTableViewController.swift
//  iosApp
//
//  Created by qaadmin on 23/06/2019.
//  Copyright © 2019 janaszek. All rights reserved.
//

import UIKit
import koreanNotebook

class SearchResultsTableViewController: UITableViewController, UISearchResultsUpdating, SearchView {
    
    let searchController = UISearchController(searchResultsController: nil)
    private lazy var presenter = ServiceLocator.init().searchPresenter
    
    private var grammar = [GrammarEntry]()
    private var vocabulary = [VocabularyEntry]()
    var query: String?
    let SectionHeaderHeight: CGFloat = 25
    
    func setSearchResult(result: Database) {
        self.grammar = result.grammar
        self.vocabulary = result.vocabulary
        tableView?.reloadData()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        presenter.attachView(view: self, param: query ?? "")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        presenter.detachView()
    }
    
    func showSearchResultFailedToLoad() {
        print("Search failed to load")
    }
    
    func setLoadingVisible(visible: Bool) {
        print("Setting loading visible \(visible)")
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.rowHeight = UITableView.automaticDimension
        tableView.estimatedRowHeight = 44.0
        searchController.searchResultsUpdater = self
        searchController.hidesNavigationBarDuringPresentation = false
        searchController.dimsBackgroundDuringPresentation = false
        searchController.searchBar.placeholder = "Type something here to search"
        searchController.searchBar.sizeToFit()
        tableView.tableHeaderView = searchController.searchBar
        
    }
    
    func updateSearchResults(for searchController: UISearchController) {
        presenter.attachView(view: self, param: searchController.searchBar.text ?? "")
    }
    
    // MARK: - Table view data source
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 2
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if section == 0 {
            return grammar.count
        }
        if section == 1 {
            return vocabulary.count
        }
        return 0
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return SectionHeaderHeight
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "SearchCell", for: indexPath)
        
        if indexPath.section == 0 {
            let grammarItem = grammar[indexPath.row]
            cell.textLabel?.text = grammarItem.title
            cell.detailTextLabel?.text = grammarItem.body
        }
        if indexPath.section == 1 {
            let vocabularyItem = vocabulary[indexPath.row]
            cell.textLabel?.text = vocabularyItem.title
            cell.detailTextLabel?.text = vocabularyItem.explanation
        }
        
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        if section == 0 {
            return "Grammar"
        }
        if section == 1 {
            return "Vocabulary"
        }
        return ""
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if indexPath.section == 0 {
            let storyboard = UIStoryboard(name: "Grammar", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "GrammarItem") as! GrammarItemViewController
            vc.grammarItem = self.grammar[indexPath.row]
            self.navigationController?.pushViewController(vc, animated: true)
        }
        if indexPath.section == 1 {
            let storyboard = UIStoryboard(name: "Vocabulary", bundle: nil)
            let vc = storyboard.instantiateViewController(withIdentifier: "VocabularyItem") as! VocabularyItemViewController
            vc.vocabularyItem = self.vocabulary[indexPath.row]
            self.navigationController?.pushViewController(vc, animated: true)
        }
    }
    
    /*
     // Override to support editing the table view.
     override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
     if editingStyle == .delete {
     // Delete the row from the data source
     tableView.deleteRows(at: [indexPath], with: .fade)
     } else if editingStyle == .insert {
     // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
     }
     }
     */
    
    /*
     // Override to support rearranging the table view.
     override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
     
     }
     */
    
    /*
     // Override to support conditional rearranging of the table view.
     override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the item to be re-orderable.
     return true
     }
     */
    
    /*
     // MARK: - Navigation
     
     // In a storyboard-based application, you will often want to do a little preparation before navigation
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
     // Get the new view controller using segue.destination.
     // Pass the selected object to the new view controller.
     }
     */
    
}
