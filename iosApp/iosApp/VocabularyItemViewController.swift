//
//  GrammarItemViewController.swift
//  iosApp
//
//  Created by qaadmin on 19/06/2019.
//  Copyright © 2019 janaszek. All rights reserved.
//

import UIKit
import koreanNotebook

class VocabularyItemViewController: UIViewController {

    @IBOutlet weak var vocabularyTitle: UILabel!
    @IBOutlet weak var vocabularyDescription: UILabel!
    var vocabularyItem: VocabularyEntry?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        if let vocabulary = vocabularyItem {
            vocabularyTitle.text = vocabulary.title
            vocabularyDescription.text = vocabulary.explanation
        }
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
