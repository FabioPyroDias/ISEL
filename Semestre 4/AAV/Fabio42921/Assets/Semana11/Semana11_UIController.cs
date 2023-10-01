using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class Semana11_UIController : MonoBehaviour
{
    [SerializeField] private RectTransform backgroundBar;
    [SerializeField] private RectTransform progressBar;
    [SerializeField] private TMP_Text messageText;
    
    [SerializeField] private float decreaseTick;
    [SerializeField] private float increaseTick;

    private float maximumSize;
    private bool isGameOver;

    // Start is called before the first frame update
    void Start()
    {
        maximumSize = backgroundBar.sizeDelta.y;

        isGameOver = false;
    }

    // Update is called once per frame
    void Update()
    {
        if(!isGameOver)
        {
            Vector2 sizeDelta = progressBar.sizeDelta;
            sizeDelta.y = Mathf.Clamp(sizeDelta.y - (maximumSize * decreaseTick) * Time.deltaTime, 0, maximumSize);

            progressBar.sizeDelta = sizeDelta;

            if(progressBar.sizeDelta.y <= 0)
            {
                messageText.color = new Color(1, 0, 0, 1);
                messageText.text = "You Lost";
                isGameOver = true;
            }
        }
    }

    public void IncreaseProgress()
    {
        if(!isGameOver)
        {
            Vector2 sizeDelta = progressBar.sizeDelta;
            sizeDelta.y = Mathf.Clamp(progressBar.sizeDelta.y + (maximumSize * increaseTick), 0, maximumSize);

            progressBar.sizeDelta = sizeDelta;

            if(progressBar.sizeDelta.y >= maximumSize)
            {
                messageText.color = new Color(0, 1, 0, 1);
                messageText.text = "You Won";
                isGameOver = true;
            }
        }
    }
}
