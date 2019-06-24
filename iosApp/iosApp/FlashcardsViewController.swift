//
//  FlashcardsViewController.swift
//  iosApp
//
//  Created by qaadmin on 23/06/2019.
//  Copyright © 2019 janaszek. All rights reserved.
//

import UIKit
import koreanNotebook

struct FlashcardsVocabulary {
    static var vocabulary = [VocabularyEntry]()
}

class FlashcardsViewController: UIViewController, WDFlashCardDelegate {
    
    var vocabulary = FlashcardsVocabulary.vocabulary
    var flashcardIndex = 0
    @IBOutlet weak var backView: UIView!
    @IBOutlet weak var frontView: UIView!
    @IBOutlet weak var flashCard: WDFlashCard!
    @IBOutlet weak var explenation: UILabel!
    @IBOutlet weak var word: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        flashCard.duration = 2.0
        flashCard.flipAnimation = .flipFromLeft
        word.text = vocabulary[flashcardIndex].title
        explenation.text = vocabulary[flashcardIndex].explanation
    }
    
    @IBAction func nextFlashcardOnClick(_ sender: UIButton) {
        if vocabulary.count < flashcardIndex {
            flashcardIndex += 1
            reloadViewFromNib()
        } else {
            
        }
    }
    
    @IBAction func flipBtnOnClick(_ sender: UIButton) {
        flashCard.flip()
    }
    
    func flipFrontView(forFlashCard flashCardView: WDFlashCard) -> UIView {
        return frontView
    }
    
    func flipBackView(forFlashCard flashCardView: WDFlashCard) -> UIView {
        return backView
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

extension UIViewController {
    func reloadViewFromNib() {
        let parent = view.superview
        view.removeFromSuperview()
        view = nil
        parent?.addSubview(view) // This line causes the view to be reloaded
    }
}
