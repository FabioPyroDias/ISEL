using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Semana6_ParticleAndSoundController : MonoBehaviour
{
    [SerializeField] private ParticleSystem particleSystemGreenOrbs;
    [SerializeField] private ParticleSystem bigExplosion;
    [SerializeField] private GameObject barrel;
    private AudioSource audioSource;

    int particleSystemCounter;

    private void Start() {
        audioSource = GetComponent<AudioSource>();
        particleSystemCounter = 0;
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyUp(KeyCode.Space))
        {
            if(particleSystemCounter == 0)
            {
                particleSystemGreenOrbs.Play();
                particleSystemCounter++;
            }
            else if(particleSystemCounter == 1)
            {
                particleSystemGreenOrbs.Stop();
                bigExplosion.Play();
                Destroy(barrel);

                audioSource.Play();
                
                particleSystemCounter++;
            }
        }
    }
}
