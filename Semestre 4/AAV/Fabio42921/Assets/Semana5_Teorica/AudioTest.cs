using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AudioTest : MonoBehaviour
{
    private AudioSource audioSource;
    [SerializeField] private AudioClip audioClip;

    // Start is called before the first frame update
    void Start()
    {
        audioSource = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyUp(KeyCode.K))
        {
            audioSource.Play();
        }

        if(Input.GetKeyUp(KeyCode.L))
        {
            audioSource.Stop();
        }

        if(Input.GetKeyUp(KeyCode.J))
        {
            audioSource.clip = audioClip;
        }

    }
}
