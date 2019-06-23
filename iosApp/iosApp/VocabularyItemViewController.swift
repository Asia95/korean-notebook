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
    var flashcardsBtn: UIBarButtonItem!
    @IBOutlet weak var vocabularyDescription: UILabel!
    var vocabularyItem: VocabularyEntry?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        flashcardsBtn = UIBarButtonItem(image: UIImage(named: "card_icon.png"), style: .plain, target: self, action: #selector(onFlashcardAdd))
        navigationItem.rightBarButtonItem = flashcardsBtn
        
        if let vocabulary = vocabularyItem {
            vocabularyTitle.text = vocabulary.title
            vocabularyDescription.text = vocabulary.explanation
        }
    }
    
    @objc func onFlashcardAdd(sender: UIBarButtonItem) {
        showToast(controller: self, message : "Added to flashcards", seconds: 2.0)
    }
    
    func showToast(controller: UIViewController, message : String, seconds: Double) {
        let alert = UIAlertController(title: nil, message: message, preferredStyle: .alert)
        alert.view.backgroundColor = UIColor.black
        alert.view.alpha = 0.6
        alert.view.layer.cornerRadius = 15
        
        controller.present(alert, animated: true)
        
        DispatchQueue.main.asyncAfter(deadline: DispatchTime.now() + seconds) {
            alert.dismiss(animated: true)
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
