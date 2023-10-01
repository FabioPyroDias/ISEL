using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Semana11_Teorica_GameController : MonoBehaviour
{

    public void ChangeLevel()
    {
        SceneManager.LoadScene("Semana11_Teorica_Level2");
    }

    public void Update()
    {
        if(Input.GetKeyDown(KeyCode.Escape))
        {
            Application.Quit();
        }
    }

}