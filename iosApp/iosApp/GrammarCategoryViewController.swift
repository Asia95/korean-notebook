//
//  CategoryViewController.swift
//  iosApp
//
//  Created by qaadmin on 19/06/2019.
//  Copyright © 2019 janaszek. All rights reserved.
//

import UIKit

class GrammarCategoryViewController: UIViewController {

    var category: String?
    
    @IBAction func onClick(_ sender: UIButton) {
        let storyboard = UIStoryboard(name: "Grammar", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "GrammarTableView") as! GrammarTableViewController
        vc.category = sender.accessibilityLabel
        self.navigationController?.pushViewController(vc, animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
