//
//  MainController.swift
//  iosApp
//
//  Created by qaadmin on 19/06/2019.
//  Copyright © 2019 janaszek. All rights reserved.
//

import UIKit

class MainController: UIViewController {

    @IBAction func grammarBtnOnClick(_ sender: UIButton) {
        let secondViewController = self.storyboard?.instantiateViewController(withIdentifier: "test") as! GrammarCategoryViewController
        secondViewController.category = sender.currentTitle
        self.navigationController?.pushViewController(secondViewController, animated: true)
    }
    
    @IBAction func vocabularyBtnOnClick(_ sender: UIButton) {
        let secondViewController = self.storyboard?.instantiateViewController(withIdentifier: "VocabularyCategory") as! VocabularyCategoryViewController
        secondViewController.category = sender.currentTitle
        self.navigationController?.pushViewController(secondViewController, animated: true)
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
