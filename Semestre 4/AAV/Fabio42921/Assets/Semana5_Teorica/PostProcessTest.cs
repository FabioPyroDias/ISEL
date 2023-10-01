using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Rendering.PostProcessing;

public class PostProcessTest : MonoBehaviour
{
    PostProcessVolume postProcessVolume;
    Vignette effect;

    // Start is called before the first frame update
    void Start()
    {
        postProcessVolume = GetComponent<PostProcessVolume>();
        postProcessVolume.profile.TryGetSettings<Vignette>(out effect);
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKey(KeyCode.K))
        {
            effect.intensity.value += 2 * Time.deltaTime;
        }

        if(Input.GetKey(KeyCode.L))
        {
            effect.intensity.value -= 2 * Time.deltaTime;
        }
    }
}
