//
//  GrammarItemViewController.swift
//  iosApp
//
//  Created by qaadmin on 19/06/2019.
//  Copyright © 2019 janaszek. All rights reserved.
//

import UIKit
import koreanNotebook

class GrammarItemViewController: UIViewController {

    @IBOutlet weak var grammarTitle: UILabel!
    @IBOutlet weak var grammarBody: UILabel!
    var grammarItem: GrammarEntry?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        if let grammar = grammarItem {
            grammarTitle.text = grammar.title
            grammarBody.text = grammar.body
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
