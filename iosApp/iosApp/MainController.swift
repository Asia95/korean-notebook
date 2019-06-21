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
        let storyboard = UIStoryboard(name: "GrammarCategory", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "GrammarCategory") as! GrammarCategoryViewController
        self.navigationController?.pushViewController(vc, animated: true)
    }
    
    @IBAction func vocabularyBtnOnClick(_ sender: UIButton) {
        let storyboard = UIStoryboard(name: "VocabularyCategory", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "VocabularyCategory") as! VocabularyCategoryViewController
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
